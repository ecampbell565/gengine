# Coding Conventions
#### Naming Conventions
Interfaces should be specified by prefixing interface names with an "I"
```java
public interface IRenderable {
...
}
```
Member variables should be specified by prefixing variable names with "m"
```java
...
GLSurfaceView mGlSurfaceView;
...
```
Constants should be declared using uppercase text separated by underscores
```java
...
public static final MAX_ENTITIES;
...
```
Import statements ordered from most local to least local; domain imports should be listed before android imports, which should be before java imports.

Package and directory names should always be **lowercase**

Variable and method names should always be **CamelCase** starting with a lowercase letter
```java
...
Renderable mRender;

public void calculateBoundaries() {
}
...
```
#### Brackets, Indentation, and Line Wrapping Convention
Curly brackets should open on the same line as the code that would necessitate their opening
```java
public void render() {
...
}
```
as opposed to 
```java
public void render()
{
...
}
```  
Indents should consist of 4 spaces, rather than tabs

Characters should be limited to about 90 per line, and wrapped lines should be directly under their preceeding line, with 2 indents. Lines should be wrapped according to these suggestions: 
* Breaking lines
  * After a comma
  * Before an operator
* Choose higher-level breaks over lower-level breaks
* Align the new line with the beginning of the expression at the same level on the previous line

#### Commenting
Methods that would prove integral to a user of the engine should be documented using javadoc format
```java
/** 
 * Implement this method to add logic code to the application
 * @param deltaTime         Time passed since previous loop in milliseconds
 */
public abstract void update(float deltaTime);
```
Avoid one-line comments, as these tend to needlessly increase line length

#### Statements
`If` and `else` statements should always be contained in curly brackets, for the purpose of clarity




