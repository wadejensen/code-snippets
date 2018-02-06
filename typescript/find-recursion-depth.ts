import { expect } from 'chai'
import 'mocha'

describe('Recursion depth testing', () => {
  it('Should return the recursion depth of this system', () => {
    function recurse(acc: number) {
      try {
        console.log(acc)
        recurse(acc + 1)
      }
      catch (e) {
        console.log("Max recursion depth on this system is: " + acc)
      }
    }
    recurse(1)
  })
})
