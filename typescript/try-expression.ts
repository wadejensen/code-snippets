/**
 * Typescript
 * A very cheeky pattern to perform a try-catch as an expression rather than a block of code.
 * This means you can kind of return a value from a try-catch without first declaring a variable.
 */


export function Try( lambda: Function, handler: Function ): any {
    try {
        return lambda.apply()
    } 
    catch (e) {
        handler.apply(e)
    }   
}

// Can be used like so:
let x: MyType = <MyType>Try( 
    () => ... arbitrary lamdba from which you are expecting an exception...  , 
    // except(err) {
        // lambda to handle the exception
        (err: Error) => console.error(err) 
    //}
)

// Rather than:

let x: MyType
try {
  x = ... code from which you are expecting an exception ...
}
catch (err) {
  // handle the exception
  console.error(err)
}


/* The result ends up being worse than just declaring the variable in vanilla *Script.
 * But wouldn't it be nice if we could return from if-else and try-catch blocks the way 
 * Scala, for example, does?
*/
