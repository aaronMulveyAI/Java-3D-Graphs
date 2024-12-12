# 3D Graphical Objects Library

## Overview
This library provides a framework for creating, manipulating, and rendering 3D graphical objects in Java. It includes classes for defining points, polygons, and complex 3D shapes, and offers tools for managing and interacting with these objects in a graphical user interface (GUI).

## Features
- **3D Object Creation**: Support for basic and complex 3D shapes including cubes, tetrahedrons, diamonds, Rubik's Cubes, and more.
- **Rendering**: Uses Java's `Graphics` API to render 3D objects on a 2D canvas.
- **Transformations**: Allows rotation and zooming of objects in real-time.
- **Interactive GUI**: Includes mouse controls for navigation and interaction.
- **Customizable Colors and Sizes**: Shapes can be created with custom sizes and colors.

## Architecture
### Key Components
1. **Point Representation**
   - `MyPoint`: Represents a 3D point with `x`, `y`, and `z` coordinates.

2. **3D Shapes**
   - `MyPoligon`: Represents a 3D polygon defined by multiple `MyPoint` objects.
   - `Tetraedron`: Represents a collection of `MyPoligon` objects to form 3D shapes.

3. **Entity System**
   - `Entity`: Manages a collection of 3D shapes (`Tetraedron`) for rendering and transformations.
   - `EntityManager`: Handles multiple entities, updates their states, and coordinates rendering.

4. **Utilities**
   - `PointConverter`: Converts 3D points to 2D coordinates for rendering, and handles scaling and rotation transformations.

5. **Input Handling**
   - `Mouse`: Captures user input for rotating and zooming objects.
   - `ClickType`: Defines various mouse click types (e.g., left click, scroll click).

6. **Builders**
   - `BasicEntityBuilder` and `ComplexEntityBuilder`: Provide factory methods for creating predefined shapes like cubes, diamonds, and Rubik's Cubes.

7. **Rendering**
   - `Display`: The main class responsible for setting up the GUI, managing the canvas, and rendering objects.

## Usage
### Setting Up
1. Include the library in your Java project.
2. Create a `Display` instance to initialize the GUI.
3. Use `BasicEntityBuilder` or `ComplexEntityBuilder` to create entities.
4. Add entities to the `EntityManager` for rendering and interaction.

### Example Code
```java
public class Main {
    public static void main(String[] args) {
        Display display = new Display();
        display.frame.setTitle("3D Render");
        display.frame.setSize(Display.WIDTH, Display.HEIGHT);
        display.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.frame.setVisible(true);

        EntityManager entityManager = new EntityManager();
        entityManager.addEntity(BasicEntityBuilder.createCube(100, 0, 0, 0));

        display.start();
    }
}
```

### Controls
- **Mouse Drag**: Rotate objects.
- **Mouse Scroll**: Zoom in/out.
- **Keyboard (`W`/`S`)**: Simulate zoom.

## Dependencies
- Java AWT and Swing libraries for rendering and user interaction.

## Extending the Library
1. **Custom Shapes**: Extend `MyPoligon` and `Tetraedron` classes to define new shapes.
2. **New Interactions**: Implement `MouseListener` and `MouseMotionListener` to add custom interactions.
3. **Advanced Rendering**: Enhance `PointConverter` for perspective corrections or lighting effects.

## Contribution
Feel free to contribute by:
- Adding new shape builders.
- Improving rendering algorithms.
- Enhancing user interaction.

