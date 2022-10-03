/* Draw a circle without floating point arithmetic
Difficulty Level : Hard
Given a radius of a circle, draw the circle without using floating point arithmetic.
Following program uses a simple concept. Let the radius of the circle be r. Consider a square of size (2r+1)*(2r+1) around the circle to be drawn. Now walk through every point inside the square. For every  point (x,y), if (x, y) lies inside the circle (or  x2+ y2 < r2), then print it, otherwise print space.
 

Approach: 

1. draw the rectangle

2. check if the point lie inside or on the circle using formula  x2+ y2 < r2.

3. If it fulfill the condition print the star else print blank space

Algorithm: 

Step 1: Take the input of radius

Step 2: Calculate the size of rectangle

Step 3: Draw the rectangle using the nested for loop

Step 4: Start coordinates from left most corner

Step 5: Check if the coordinates lie inside the circle, if yes Print the star else print blank space.*/


class GFG
{
static void drawCircle(int r)
{
	// Consider a rectangle of size N*N
	int N = 2*r+1;

	int x, y; // Coordinates inside the rectangle

	// Draw a square of size N*N.
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			// Start from the left most corner point
			x = i-r;
			y = j-r;

			// If this point is inside the circle, print it
			if (x*x + y*y <= r*r+1 )
				System.out.print(".");
			else
				// If outside the circle, print space
				System.out.print(" ");

			System.out.print(" ");
		}

		System.out.println();
	}
}

// Driver Program to test above function
public static void main(String arg[])
{
	drawCircle(8);
}
}
