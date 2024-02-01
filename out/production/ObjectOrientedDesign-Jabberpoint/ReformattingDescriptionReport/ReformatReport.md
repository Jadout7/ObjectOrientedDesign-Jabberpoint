# A list of changes done to JabberPoint

| Case | Problem                                                               | Solution                                                                                                                                                  | 
|------|-----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Random unused constructors and variables in multiple classes          | Removed the extra unused constructors and variables to make code readable                                                                                 | 
| 2    | Too many static variables in multiple classes                         | Moved all static variables to multiple interfaces in the `src.Constants` Package to make variables easier to access and modify                            | 
| 3    | Switch case unnecessarily complicated in `KeyController`              | Simplified switch case by using multiple comma seperated values                                                                                           |  
| 4    | Bug where you can go to a slide number that is non existent           | Added an if statement so that you can't land on a non existent slide                                                                                      |
| 5    | Clumping of Loaders and Savers                                        | Split `Accessor` and `XMLAccessor` into their own classes: `AccessorLoader`,`AccessorSaver`,`XMLLoader` and `XMLSaver` to load and save the presentations |
| 6    | Naming of methods hard to understand                                  | Renamed append methods to `addSlideItem()` and `addTextItem()` to have better understanding of what each `append` function does                           |
| 7    | Lack of scalability and harder to implement changes later on          | Split the constructor into `File`, `View` and `Help` menu buttons for easier addition of features                                                         |
| 8    | Two way link between `Presentation` and `SlideViewerComponent` class  | Removed dependency of `slideViewerComponent` from `Presentation` class                                                                                    | 

