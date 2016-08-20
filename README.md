#Simple Neural Networks with Java 8
This is a simple experimental Neural Network implemented with Java 8 features. It's a kind of linear decision boundary which is known as "Frank Rosenblatt" Perceptron.

##Build & Run
The project is built by Gradle. Go to the root directory and execute below command.

    gradle build

If you want to import project to Eclipse, please execute below command.

	gradle eclipse

Also, to install Gradle plugin in Eclipse will be more convenience.

The main test method is located at *src/test/java/com/sample/SimpleTest.java*

Another advanced test method is located at *src/test/java/com/sample/AdvancedTest.java*

##Algorithm
The details of algorithm can be referred in wiki page [Perceptron](https://en.wikipedia.org/wiki/Perceptron). We only consider a single layer perceptron. 

##Verification
We defined two kinds of verification testings. The simple one is along with class *SimpleTest.java*, which includes a two-dimension dataset. With this sample, you can explicitly see how the algorithm adjusts weights in each round. Below is the example.

<img src="src\test\resources\images\1.jpg" width = "150" alt="Round 1" align=center />
<img src="src\test\resources\images\2.jpg" width = "150" alt="Round 2" align=center />
<img src="src\test\resources\images\3.jpg" width = "150" alt="Round 3" align=center />
<img src="src\test\resources\images\4.jpg" width = "150" alt="Round 4" align=center />
<img src="src\test\resources\images\5.jpg" width = "150" alt="Round 5" align=center />  

<img src="src\test\resources\images\6.jpg" width = "150" alt="Round 6" align=center />
<img src="src\test\resources\images\7.jpg" width = "150" alt="Round 7" align=center />
<img src="src\test\resources\images\8.jpg" width = "150" alt="Round 8" align=center />
<img src="src\test\resources\images\9.jpg" width = "150" alt="Round 9" align=center />
<img src="src\test\resources\images\10.jpg" width = "150" alt="Round 10" align=center />  

<img src="src\test\resources\images\11.jpg" width = "150" alt="Round 11" align=center />

Finally, it finds a perfect linear classifier for the given dataset.

----------

For advanced sample, we use the best known dataset in the pattern recognition literature - ***Iris***, as our testing data. We only focus on the first two flowers.

According to tradition, we shuffle and divide the dataset into two parts: Training set (70%) and Testing set (30%). We may run the main method several times to get the average results. 

Below is the accurency FYI.

> Round 1: 1.0
 
> Round 2: 1.0

> Round 3: 1.0

> Round 4: 1.0

> Round 5: 1.0

> Round 6: 1.0

> Average: 1.0

We can say, for *Iris* dataset, perceptron is superior to KNN.

##Reference

**Perceptron:** https://en.wikipedia.org/wiki/Perceptron

**Iris:** http://archive.ics.uci.edu/ml/datasets/Iris