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
**Objective**:
Develop a Convolutional Neural Network (CNN) model to classify emotions from facial expressions in images.

**Description**:
This assignment involved building a CNN architecture to analyze facial features and categorize them into different emotions (e.g., anger, happiness, surprise). Techniques like data augmentation and transfer learning were explored to enhance model performance.

#### Result Summary
We explored various CNN architectures and hyperparameter configurations, achieving an accuracy of 57% (ADAM) and 58% (SGD) on unseen data. The models showed promise in recognizing emotions from real-life videos, highlighting their potential for real-world applications.

## Data Mining

### First Assignment - Regression
**Objective**:
The objective of this Regression Lab assignment was to equip us with practical skills in:

* Analyzing and interpreting linear regression models to understand relationships between variables.
* Building and evaluating regression models using Python libraries like scikit-learn.
* Employing data visualization techniques to assess model performance and data distribution.
* Comparing the effectiveness of different regression models (linear vs. polynomial vs. Lasso) for specific tasks.
* Identifying potential limitations of regression models and exploring alternatives like Lasso regression for feature selection.

**Description**:
This assignment delves into the world of regression analysis through a series of practical exercises. We were working with a pre-built linear regression model to explore gender bias in salary prediction. Additionally, we were simulating our own data to gain hands-on experience with:

* Data generation using Python libraries.
* Fitting linear and polynomial regression models.
* Interpreting model coefficients and evaluating performance using R-squared metric.
* Understanding the trade-offs involved in using Lasso regression for model fitting.

#### Result Summary
*Gender Bias Analysis*:
The model shows a bias favoring females for starting salary when holding other factors constant.
The interaction term suggests a smaller impact of GPA on female starting salary compared to males.

*Model Fitting & Visualization*:
Explored linear and polynomial regressions using simulated data.
Compared model performance using R-squared metric.
Quadratic term improved model fit for polynomial data.

*LASSO Regression*:
LASSO models initially underperformed due to feature selection (setting coefficients to zero).
Tuning the alpha parameter improved performance for both linear and quadratic models.

### Third Assignment - Caravan-Insurance Problem
**Objective**:
Assist a Dutch insurance company in targeting potential customers for caravan insurance through direct mail campaigns.

**Tasks**:

* *Identify Ideal Customer*: Analyze customer data (demographics, product usage) to understand characteristics of those with caravan insurance. Utilize techniques like regression, decision trees, and visualizations. Compare different methods for clarity and effectiveness.

* *Target High-Potential Customers*: Employ the most accurate classification model from Assignment 1 to select 800 test samples most likely to own caravan insurance.


#### Result Summary
Analyzed caravan insurance data to identify ideal customers for direct mail campaigns. Built models to predict unlikely non-owners, finding key features like "Number of boat policies." Identified top 800 leads with lowest probability of NOT being interested in caravan insurance.

### Fourth Assignment - Clustering
**Objective**:


**Description**:

#### Result Summary


### Fifth Assignment - Apriori Algorithm
**Objective**:


**Description**:

#### Result Summary

