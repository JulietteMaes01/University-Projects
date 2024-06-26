# University Projects

This repository contains a collection of projects completed during my Bachelor's and Master's courses at Maastricht University. These projects span various domains including Machine Learning, Computer Vision, Data Mining, and Signal and Image Processing, showcasing a diverse set of skills and knowledge acquired throughout my studies.

## Bachelor's Projects

### 1. Programming Course: Game Development
**Objective**: Create a small game to play on a laptop as part of a programming course.

**Description**: This project involved designing and implementing a simple game using fundamental programming concepts. The game was developed to run on a laptop, providing an interactive and fun way to apply learned skills.

**Result Summary**: The game featured basic graphics, user controls, and a scoring system. It provided a hands-on experience in software development and debugging, reinforcing programming logic and problem-solving skills.

**Code**: [🔗 Check out the Game Development Code!](BachelorProjects/Assignment%20PRA2003%20Part1)

### 2. Formula 1 Predictions using Machine Learning
**Objective**: Predict Formula 1 race outcomes using machine learning algorithms.

**Description**: This project involved analyzing historical Formula 1 race data and building predictive models to forecast race results. Various machine learning techniques were explored to enhance prediction accuracy.

**Result Summary**: Different models, including regression and classification algorithms, were evaluated. The project highlighted the impact of feature selection, data preprocessing, and model tuning on prediction performance.

**Code**: [🔗 Explore the Formula 1 Predictions Code!](path_to_your_formula1_code_repo)

## Master's Projects

### Research Project: 
#### Singular Spectrum Decomposition for Predictive Maintenance
**Objective**: Develop a methodology using Singular Spectrum Decomposition (SSD) to perform predictive maintenance on industrial machinery.

**Description**: This project aimed to leverage the SSD technique to analyze time series data from machinery. The objective was to predict failures and maintenance needs before they occur, ensuring smoother operation and reducing downtime.

**Goal**: By applying SSD, we were able to decompose the time series data into various components, identifying trends and periodicities. This allowed for more accurate predictions of machine failures and the scheduling of maintenance activities.

**Result**: Still under investigation

**Code**: [🔗 Check out the Singular Spectrum Decomposition Project!](https://github.com/Aurelien-Bertrand/ssd_for_predictive_maintenance.git)

### Advanced Concepts of Machine Learning

#### 1. Backpropagation
**Objective**: Implement a custom Neural Network without relying on high-level libraries to understand the fundamentals of backpropagation.

**Description**: The task involves creating a Neural Network architecture with three layers: input, hidden, and output. Backpropagation, a key algorithm for training neural networks, is implemented to adjust the network's weights and biases based on the error between predicted and actual outputs.

**Result Summary**: Our experiments involved varying learning rates (alpha values) and different initialization strategies for weights and biases. We discovered that:

- **Convergence**: Network converged around 100 epochs; stable values achieved after ~10,000 epochs.
- **Initialization**: Random initialization of weights and biases was more effective than zero initialization.
- **Accuracy**: Achieved 100% accuracy with a low test loss of 0.0018.
- **Output**: Model successfully reproduced exact input values, confirming its learning and generalization capabilities.

**Code**: [🔗 Check out the Backpropagation Code!](MasterProjects/ACML/ACML1_Backpropagation_Assignment.ipynb)

#### 2. Convolutional Autoencoders
**Objective**: Build an Autoencoder (AE) using deep learning techniques to work with the CIFAR-10 dataset. The tasks involved reconstructing input images and performing colorization.

**Description**: The network takes images as input, generates a representation in latent space, and attempts to reconstruct the original image as precisely as possible. This process helps in understanding the encoding and decoding capabilities of autoencoders.

**Result Summary**: We trained some of the models with different values for stride (1 and 2). Our hypothesis was that using stride 2, the model will miss features from the images, leading to poor results in learning. This expectation was confirmed, and the difference between loss values is almost 10x (of course in favor of training with stride=1).

- Example:
  - Stride=1, Test loss = 0.0054
  - Stride=2, Test loss = 0.0445

**Code**: [🔗 Explore the Convolutional Autoencoders Code!](MasterProjects/ACML/ACML_Assignment_2.ipynb)

### Computer Vision

#### 1. Image Segmentation
**Objective**: Develop an image segmentation application using the Mean Shift algorithm.

**Description**: The Mean Shift algorithm clusters an n-dimensional data set by associating each point with a peak of the data set's probability density. The task involves implementing functions to find peaks and clusters and incorporating speed-ups to improve the algorithm's efficiency.

**Result Summary**: The assignment showcased the importance of parameter selection and optimization techniques in achieving accurate and efficient image segmentation. Here are the key findings:

- Implementation of pre-processing steps such as RGB to LAB conversion and feature matrix creation facilitated efficient segmentation.
- The Mean Shift algorithm, along with optimizations such as the basin of attraction speed-up, demonstrated effective clustering of image data.
- Evaluation of segmentation performance across different parameter configurations revealed variations in segmentation precision and computational efficiency.
- Analysis of segmented images provided insights into the impact of radius, threshold, and feature types on segmentation results.
- Comparison between 3D and 5D feature vectors highlighted differences in segmentation performance and computational requirements.

**Code**: [🔗 Delve into the Image Segmentation Code!](MasterProjects/CV/Assignent%201%20-%20CV-FINAL.ipynb)

#### 2. Deep Learning for Emotions Recognition
**Objective**: Develop a Convolutional Neural Network (CNN) model to classify emotions from facial expressions in images.

**Description**: This assignment involved building a CNN architecture to analyze facial features and categorize them into different emotions (e.g., anger, happiness, surprise). Techniques like data augmentation and transfer learning were explored to enhance model performance.

**Result Summary**: We explored various CNN architectures and hyperparameter configurations, achieving an accuracy of 57% (ADAM) and 58% (SGD) on unseen data. The models showed promise in recognizing emotions from real-life videos, highlighting their potential for real-world applications.

**Code**: [🔗 Discover the Deep Learning for Emotions Recognition Code!](MasterProjects/CV/Assignment2_Deep_Learning.ipynb)

### Data Mining

#### 1. Regression
**Objective**: Equip students with practical skills in analyzing and interpreting linear regression models, building and evaluating regression models, and employing data visualization techniques.

**Description**: This assignment delves into regression analysis through a series of practical exercises. We worked with a pre-built linear regression model to explore gender bias in salary prediction and simulated our own data to gain hands-on experience.

**Result Summary**:
- **Gender Bias Analysis**:
  - The model shows a bias favoring females for starting salary when holding other factors constant.
  - The interaction term suggests a smaller impact of GPA on female starting salary compared to males.
- **Model Fitting & Visualization**:
  - Explored linear and polynomial regressions using simulated data.
  - Compared model performance using R-squared metric.
  - Quadratic term improved model fit for polynomial data.
- **LASSO Regression**:
  - LASSO models initially underperformed due to feature selection (setting coefficients to zero).
  - Tuning the alpha parameter improved performance for both linear and quadratic models.

**Code**: [🔗 Explore the Regression Lab Notebook!](MasterProjects/DM/DM%20-%20LAB%201.ipynb)

#### 2. Caravan-Insurance Problem
**Objective**: Assist a Dutch insurance company in targeting potential customers for caravan insurance through direct mail campaigns.

**Tasks**:
- Identify Ideal Customer: Analyze customer data to understand characteristics of those with caravan insurance using regression, decision trees, and visualizations.
- Target High-Potential Customers: Employ the most accurate classification model to select 800 test samples most likely to own caravan insurance.

**Result Summary**: Analyzed caravan insurance data to identify ideal customers for direct mail campaigns. Built models to predict unlikely non-owners, finding key features like "Number of boat policies." Identified top 800 leads with the lowest probability of NOT being interested in caravan insurance.

**Code**: [🔗 Dive into the Caravan Insurance Problem Code!](MasterProjects/DM/DM%20-%20LAB3.ipynb)

#### 3. Clustering
**Objective**: Explore K-Means and hierarchical clustering algorithms for data analysis, focusing on cluster formation, visualization techniques, and evaluation metrics.

**Description**: The tasks involved generating data, analyzing cluster formation with K-Means, investigating the impact of parameters, performing hierarchical clustering, and applying DBSCAN clustering to a real-world dataset.

**Result Summary**:
- **K-Means Clustering**:
  - The "elbow method" on the SSE plot identified 4 as the optimal number of clusters for the generated data.
  - Higher standard deviation spread the clusters but didn't affect the number of clusters identified by K-Means.
  - Different random state values led to slightly different clustering solutions, highlighting the dependence on initialization. KMeans++ can be a less random alternative.
- **Hierarchical Clustering**:
  - Max-linkage clustering produced the most biologically sensible hierarchy for the vertebrate data, considering class and feature relationships.
- **DBSCAN Clustering**:
  - Parameters significantly impacted cluster formation. A balanced combination of eps and min_samples is crucial for effective noise handling and cluster identification.

**Code**: [🔗 Dive into the Clustering Code!](MasterProjects/DM/DM%20-%20LAB4%20IMPROVED%20EFFICIENCY.ipynb)

#### 4. Apriori Algorithm
**Objective and Description**: Explore the Apriori algorithm to discover frequent itemsets and association rules in transactional datasets, gaining insights into customer behavior and market trends.

**Result Summary**: The findings were to use Apriori to find patterns (frequent itemsets) in data (T10I4D100K, Mushroom) and then use those patterns to make rules. Lower thresholds find more patterns but take longer. Identified trends like Team A's higher likelihood of winning at home against Team C than Team B.

**Code**: [🔗 Explore the Apriori Algorithm Testing Code!](MasterProjects/DM/DM%20-%20LAB5.ipynb)

### Signal and Image Processing

For this course, various labs were completed as assignments. The MATLAB scripts associated with each lab provide detailed information on the specific tasks and methodologies.

#### Labs Overview
The labs covered the following topics:
- [Image Analysis](MasterProjects/SIP/TemplateLab1_imageanalysis.mlx)
- [Fourier Analysis](MasterProjects/SIP/LAB2-Fourier.m)
- [Convolution and Filtering](MasterProjects/SIP/TemplateLab3_Convandfilter.mlx)
- [Time Frequency Representation and Haar Wavelets](MasterProjects/SIP/TemplateLab4_Haar.mlx)
- [Principal Component Analysis](MasterProjects/SIP/LAB5-PCA.mlx)
- [Debauchies Wavelets](MasterProjects/SIP/TemplateLab6_Debauchies.mlx)
- [Wavelet Shrinkage](MasterProjects/SIP/TemplateLab7_shrinkage.mlx)

**Result Summary**: Each lab focused on a different aspect of signal and image processing, allowing for a comprehensive understanding of theoretical concepts and practical applications. The MATLAB scripts contain the implementations and results for each topic.
