# University-Projects
Here are all the different projects that I completed during my Bachelor’s and Master’s courses at Maastricht University.

## Advanced Concepts of Machine Learning

### First Assignment - Backpropagation
**Objective**:
Implement a custom Neural Network without relying on high-level libraries to understand the fundamentals of backpropagation.

**Description**:
The task involves creating a Neural Network architecture with three layers: input, hidden, and output. Backpropagation, a key algorithm for training neural networks, is implemented to adjust the network's weights and biases based on the error between predicted and actual outputs.

#### Result summary
Our experiments involved varying learning rates (alpha values) and different initialization strategies for weights and biases. We discovered that:

* **Convergence**: Network converged around 100 epochs; stable values achieved after ~10,000 epochs.
* **Initialization**: Random initialization of weights and biases was more effective than zero initialization.
* **Accuracy**: Achieved 100% accuracy with a low test loss of 0.0018.
* **Output**: Model successfully reproduced exact input values, confirming its learning and generalization capabilities.


### Second Assignment - Convolutional Autoencoders
**Objective**:
Build an Autoencoder (AE) using deep learning techniques to work with the CIFAR-10 dataset. The tasks involved reconstructing input images and performing colorization.

**Description**:
The network takes images as input, generates a representation in latent space, and attempts to reconstruct the original image as precisely as possible. This process helps in understanding the encoding and decoding capabilities of autoencoders.
#### Result summary
We trained the some of the models with different values for stride (1 and 2). Our hypothesis was that using stride 2, the model will miss features from the images, leading to poor results in learning. This expectations were confirmed, and the difference between loss values is almost 10x (of course in favor of training with stride=1).
 Example:
 Stride=1, Test loss = 0.0054
 Stride=2, Test loss = 0.0445

## Computer Vision

### First Assignment - Image Segmentation
**Objective**:
Develop an image segmentation application using the Mean Shift algorithm.

**Description**:
The Mean Shift algorithm clusters an n-dimensional data set by associating each point with a peak of the data set's probability density. The task involves implementing functions to find peaks and clusters and incorporating speed-ups to improve the algorithm's efficiency.

#### Result Summary
The assignment showcased the importance of parameter selection and optimization techniques in achieving accurate and efficient image segmentation here are the key findings:

* Implementation of pre-processing steps such as RGB to LAB conversion and feature matrix creation facilitated efficient segmentation.
* The Mean Shift algorithm, along with optimizations such as the basin of attraction speed-up, demonstrated effective clustering of image data.
* Evaluation of segmentation performance across different parameter configurations revealed variations in segmentation precision and computational efficiency.
* Analysis of segmented images provided insights into the impact of radius, threshold, and feature types on segmentation results.
* Comparison between 3D and 5D feature vectors highlighted differences in segmentation performance and computational requirements.

### Second Assignment - Deep Learning for Emotions Recognition
...

#### Result Summary
... 
