 // Activatable Mixin
 export class Activatable {
    isActive: boolean;
    activate() {
        console.log("Activate, activate, activate")
       this.isActive = true;
    }
    deactivate() {
       this.isActive = false;
    }
 }
 
