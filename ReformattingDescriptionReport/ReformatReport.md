# A list of initial changes done to JabberPoint

| Case | Problem                                                              | Solution                                                                                                                                                  | 
|------|----------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Random unused constructors and variables in multiple classes         | Removed the extra unused constructors and variables to make code readable                                                                                 | 
| 2    | Too many static variables in multiple classes                        | Moved all static variables to multiple interfaces in the `JabberpointSRC.Constants` Package to make variables easier to access and modify                 | 
| 3    | Switch case unnecessarily complicated in `KeyController`             | Simplified switch case by using multiple comma seperated values                                                                                           |  
| 4    | Bug where you can go to a slide number that is non existent          | Added an if statement so that you can't land on a non existent slide                                                                                      |
| 5    | Clumping of Loaders and Savers                                       | Split `Accessor` and `XMLAccessor` into their own classes: `AccessorLoader`,`AccessorSaver`,`XMLLoader` and `XMLSaver` to load and save the presentations |
| 6    | Naming of methods hard to understand                                 | Renamed append methods to `addSlideItem()` and `addTextItem()` to have better understanding of what each `append` function does                           |
| 7    | Lack of scalability and harder to implement changes later on         | Split the constructor into `File`, `View` and `Help` menu buttons for easier addition of features                                                         |
| 8    | Two way link between `Presentation` and `SlideViewerComponent` class | Removed dependency of `slideViewerComponent` from `Presentation` class                                                                                    |

___

# Changes after Feedback

### A list of changes related to Functionality

| Case | Problem                                                              | Solution                                                                      | 
|------|----------------------------------------------------------------------|-------------------------------------------------------------------------------|
| 1    | Test Presentation issue with loading                                 | Removed the local path in the `testPresentation.xml` file                     |


### A list of changes related to Reliability and Usability

| Case | Problem                                                                     | Solution                                                                              | 
|------|-----------------------------------------------------------------------------|---------------------------------------------------------------------------------------|
| 1    | Unintended modification of variables leading to unexpected behavior or bugs | Made variables in multiple classes as final to make the code less error-prone         |
| 2    | No indication in the application that a file can't be found                 | Added a FileNotFoundException throw in the `LoadFile` method of the `XMLLoader` class |

### A list of changes related to Testability

| Case | Problem                                                                          | Solution                                                                                                  | 
|------|----------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| 1    | No functionality when input below 1 or above maximum number of slides is entered | Added boundaries to the `MoveToSlide` method in `MenuController` class                                    |
| 2    | No functionality when wrong input type is entered                                | Added a try catch for error handling of wrong input in the `MoveToSlide` method in `MenuController` class |

### A list of changes related to Maintainability

| Case | Problem                                                                   | Solution                                                                                                                                                           | 
|------|---------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1    | Method too large and complex, making it difficult to understand or extend | Split `LoadFile` method in `XMLLoader` class into smaller methods, removed unused method calls, and extracted `ParsePresentation` method from the `XMLSaver` class | 
| 2    | Lack of type-safety and readability                                       | Refactored the constant interfaces to enums                                                                                                                        |
| 3    | Unnecessary clutter in `DemoPresentation` class                           | Removed unused method in `DemoPresentation` class                                                                                                                  |
| 4    | Unclear method naming                                                     | Renamed `Update` method to `UpdateSlide` in `SlideViewerComponent` for more clarity                                                                                | 