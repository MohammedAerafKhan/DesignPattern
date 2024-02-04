// ModelController.h: header file for model Controller
// created by Madhur Saluja, Tasbi Tasbi and Mohammed Aeraf Khan
#ifndef _MODELCONTROLLER_H_
#define _MODELCONTROLLER_H_

#include"View.h"
#include"ConsoleView.h"
#include"GraphicalView.h"
#include"Model.h"

class ModelController {
private:
	std::vector<View*> views;
	Model model;
public:
	ModelController();
	void trainModel();
	double makePredictions(std::vector<double>& inputData);
	void DisplayPrediction(double predictions);
	~ModelController();
};
#endif // !