# Alert

"Alert" is an ImageJ plugin that allows to draw user attention on the status bar or on specific image windows by permanently or temporarily giving those objects a chosen color.

It's located in Plugins>Utilities>Alert. 

![image|313x299](https://aws1.discourse-cdn.com/business4/uploads/imagej/original/3X/3/d/3d67e15f45410fd43d5ac0031be6a179052ec92f.png) 

![image|690x169](https://aws1.discourse-cdn.com/business4/uploads/imagej/original/3X/b/c/bc6bd448e0a3e57796806eca5a0d7a1ca7324792.png) 

* Choose object to apply alert to from status bar or active image.
* Choose color to apply
* Use a duration>0 for just flashing the color. 500 will change the color for 500 ms.
* Or use duration<=0 to change the color permanently.

![image|690x182](https://aws1.discourse-cdn.com/business4/uploads/imagej/original/3X/4/d/4d7b5f381e8a1da7fe83b4b69a20867d728a36a1.jpeg) 


In a macro, use something like:

```
run("Blobs (25K)");
run("Alert ", "object=Image color=Green duration=1000");
```
