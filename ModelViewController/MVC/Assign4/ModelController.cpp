#include"ModelController.h"

ModelController::ModelController() {
	// Initialize views vector with default views, can have more views.
	views.push_back(new ConsoleView());
	views.push_back(new GraphicalView());
}

void ModelController::trainModel() {
	// Train the model using the associated Model object
	return model.train();
}

// Make predictions using the trained model
double ModelController::makePredictions(std::vector<double>& inputData) {
	double predictions = model.predict(inputData);
	return predictions;
}

// Display predictions in all views
void ModelController::DisplayPrediction(double predictions) {
	for (int i = 0; i < size(views); ++i) {
		views[i]->displayPrediction(predictions);
	}
}

ModelController::~ModelController() {
	// Delete the dynamically allocated views
	for (View* view : views) {
		delete view;
	}
	// Clear the vector after deleting the views
	views.clear();
}