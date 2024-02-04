//MultiViewData.cpp - main function for the multi-view data
// edited by Mohammed Aeraf Khan
#include <vector>
#include <iostream>
#include "ModelController.h"

int main() {
    std::vector<double> inputData;
    int ret = 0;

    // Add code

    // Training the model. Model can be controlled using controller
    ModelController controller;
    controller.trainModel();

    if (ret == 0) {
        // Generate some random data and make predictions, five times
        const int TRIALS = 5;
        for (int i = 0; i < TRIALS; ++i) {
            const int NUM = 1000;
            for (int j = 0; j < NUM; ++j) {
                inputData.push_back((double)(rand() % 1000) / 1000);//generate a number between 0 and 1
            }

            // Makeing a prediction using the trained model
            double prediction = controller.makePredictions(inputData);

            // displaying the prediction in all views
            controller.DisplayPrediction(prediction);
            
            //clear out the vector for the next trial
            inputData.clear();
            std::cout << std::endl;
        }
    }
    return ret;
}
