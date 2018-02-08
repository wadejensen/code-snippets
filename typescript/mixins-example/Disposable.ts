// Disposable Mixin
export class Disposable {
    isDisposed: boolean;
    dispose() {
        console.log("Dispose")
       this.isDisposed = true;
    }
 }
