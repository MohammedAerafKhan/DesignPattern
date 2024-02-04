#include <iostream>
#include"View.h"

#ifndef _CONSOLEVIEW_H_
#define _CONSOLEVIEW_H_

class ConsoleView : public View {
public:
    // display predictions on console
    void displayPrediction(double prediction) override {
        std::cout << "Console Prediction: " << prediction << std::endl;
    }
};

#endif