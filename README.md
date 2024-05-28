# University-Projects
Here are all the different projects that I completed during my Bachelor’s and Master’s courses at Maastricht University.

## Advanced Concepts of Machine Learning

### First Assignment - Backpropagation
For this assignment, we had to implement our own Neural Network without relying on high-level libraries (Keras, TensorFlow, etc.). We implemented backpropagation to produce and train a network with 3 layers: input, hidden, and output. 

An example of what to aim for: when the input layer is given `<0,0,0,1,0,0,0,0>` as input, the output to aim for is also `<0,0,0,1,0,0,0,0>`.

We also studied the weights and activations of the hidden nodes of our network to interpret them.

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
