// model.cpp: cpp file for model class

#include"Model.h"

// Train the model using a Taylor series approximation of a sine wave
void Model::train() {
	const double w = 2.0 * PI * freq;
	const double P = 1.0 / freq;
	double time;
	int error = 1;

	weights.resize(steps);
	do {
		std::vector<double> Coefficients = generateCoefficients(expansionFactor);
		for (int i = 0; i <= steps / 4; ++i) {
			time = P * (double)i / steps;  // from 0 to P seconds
			double x = w * time;

			// Use the Taylor series coefficients to generate weights
			double weight = 0.0;
			for (int j = 0; j <= expansionFactor; ++j) {
				weight += Coefficients[j] * pow(x, 2 * j + 1);
			}

			weights[i] = weight;

			#ifdef TEST_BUILD
			// Visualize the accuracy of the Taylor Series
			std::cout.precision(6);
			std::cout.setf(std::ios::fixed);
			double trueValue = sin(x);
			std::cout << "i: " << i << " time: " << time << " weights:" << weights[i] << " trueValue: " << trueValue << std::endl;
			#endif
		}

		//Generate the second quarter of the sine wave from the first quarter
		for (int i = steps / 4; i < steps / 2; ++i) {
			weights[i] = weights[steps / 2 - i];
		}

		//Generate the second half of the sine wave from the first half
		for (int i = steps / 2; i < steps; ++i) {
			weights[i] = -weights[i - steps / 2];
		}

		error = errorAnalysis();
		#ifdef TEST_BUILD
		cout << error << endl;
		#endif
		if (error == -1) {
			incrementexpansionFactor();
		}

	} while (error != 0);
	return;
}

// Analyze the error between the model's weights and the true sine wave
int Model::errorAnalysis() {
	double stdDev = 0.0;
	const double TOLERANCE = 0.001;
	int retVal = 0;
	const double w = 2.0 * PI * freq;
	const double P = 1.0 / freq;//the period
	double diffSum = 0.0;
	for (int i = 0; i < steps; ++i) {
		double time = P * (double)i / steps;
		double trueValue = sin(w * time);
		diffSum += (weights[i] - trueValue) * (weights[i] - trueValue);
	}
	stdDev = sqrt(diffSum / (steps - 1));
	if (stdDev > TOLERANCE) {
		std::cout << std::endl << "stdDev: " << stdDev << std::endl;
		std::cout << "ERROR: The training model is inaccurate!" << std::endl << std::endl;
		retVal = -1;
	}
	else {
		std::cout << "The training model is accurate." << std::endl << std::endl;
	}
	return retVal;
}

// Generate coefficients for the Taylor series expansion up to a given factor
std::vector<double> Model::generateCoefficients(int expansionFactor) {
	std::vector<double> coefficients;

	for (int i = 0; i <= expansionFactor; ++i) {
		double fact = 1.0;
		for (int j = 1; j <= 2 * i + 1; ++j) {
			fact *= j;
		}

		double term = (i % 2 == 0 ? 1 : -1) / fact;
		coefficients.push_back(term);
	}

	#ifdef TEST_BUILD
	for (int i = 0; i < coefficients.size(); i++) {
		cout << coefficients[i] << endl;
	}
	#endif

	return coefficients;
}

// Increment the expansion factor to extend the Taylor series
void Model::incrementexpansionFactor() {
	expansionFactor += 1;
	return;
}

// Compute the dot product of two vectors
double Model::dotProduct(std::vector<double>& vec1, std::vector<double>& vec2) {
	if (vec1.size() != vec2.size()) {
		if (vec1.size() > vec2.size()) {
			vec1.resize(vec2.size());
		}
		else {
			vec2.resize(vec1.size());
		}
	}

	double result = 0;
	for (size_t i = 0; i < vec1.size(); ++i) {
		result += vec1[i] * vec2[i];
	}

	return result;
}

// Make predictions using the trained model
double Model::predict(std::vector<double>& inputData) {
	double prediction = dotProduct(weights, inputData);
	return prediction;
}