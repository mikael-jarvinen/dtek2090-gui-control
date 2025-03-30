# DTEK2090-2025 Modern user interfaces Programming exercise

## Assignment

Custom GUI control: One component per group member. Implement custom GUI control(s) that perform functionality utilizing the advanced concepts
of this course (e.g. asynchronous / concurrent background processes / threads).

Assignment is done in group of one.

## Implementation

To demonstrate threads / concurrency in UI work, I decided to implement a button that once clicked fetches a random image and then displays the result once it has fetched the image.
The button's event handler is executed in a new thread so that the task does not block the UI. To demonstrate this task not blocking the UI I added a real-time clock in the UI.

If you try out the application you can see that once you click the button and the image fetch process begins, it is not blocking the other UI as the real-time clock continues to tick.

![image](https://github.com/user-attachments/assets/c6354a21-91d7-4c15-96ec-21c907b0a051)

## Running

Install the dependencies from pom.xml
then run
```mvn clean javafx:run```
