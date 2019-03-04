# Artificial Neural Network implementation using Weka and ImageJ

This Java application uses a MultilayerPerceptron model that is able to classify images from 10 different categories, such as:

- Leopards
- Airplanes
- Motorbikes
- Brains
- Chandeliers
- A car viewed from the side
- Faces
- Watches
- Pianos
- Accordions

-------------------------

## About the project

This application is an implementation of a college project in the Artificial Intelligence course. 

The goal of the this project was to model a Multilayer Perceptron experimentally by analizing error curves and chosing the set of hyperparameters that gets the best results. The data to make the curves and the model training I got from [Weka 3.8.3](https://www.cs.waikato.ac.nz/ml/weka/ "Link to Weka Software"). 

The [ImageJ] (https://imagej.nih.gov/ij/ "Link to ImageJ software") was used to process the images, extract the attributes and generate the ARFF file for usage in the model training.

The dataset used in the project is from [Caltech101] (http://www.vision.caltech.edu/Image_Datasets/Caltech101/ "Link to the dataset")

-------------------------

## Application details

- You need to provide a path in the "File Path" field to a folder in your computer where the program can get the image you want the model to classify, if more than 1 image is in the folder, the program will process only the first one, so if you want to use more than one image, do it one by one.

- Also, you need to provide a path to a '.model' file generated by Weka to test it, in this repository, I've included my own model that I made for my College project, but if you have your own, you can test it using this program, just save your model and put the path for it int the "Model Path" field.
