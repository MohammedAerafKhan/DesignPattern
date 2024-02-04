// Model.h: header file for model class
// created by Madhur Saluja, Tasbi Tasbi, Mohammed Aeraf Khan
#ifndef _MODEL_H_
#define _MODEL_H_

#ifdef TEST_BUILD
#define _USE_MATH_DEFINES
#include <cmath>
#endif
#include <iomanip>//setw()
#include <iostream>
#include <vector>

using namespace std;

class Model {
private:
	vector<double> weights;
	const double freq = 50.0;
	const int steps = 360;
	const double PI = 3.141592653589793238;
	double currSeries = 0;
	int expansionFactor = 0;
public:
	void train();
	int errorAnalysis();
	std::vector<double> generateCoefficients(int expansionFactor);
	void incrementexpansionFactor();
	double dotProduct(std::vector<double>& vec1,std::vector<double>& vec2);
	double predict(std::vector<double>& inputData);
};

#endif