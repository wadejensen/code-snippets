import { Disposable } from "./disposable"
import { Activatable } from "./activatable"

import { Mixin } from "./Mixin";

@Mixin([Disposable, Activatable])
export class Widget implements Disposable, Activatable {
   // Disposable
   isDisposed: boolean = false;
   dispose: () => void;
   // Activatable
   isActive: boolean = false;
   activate: () => void;
   deactivate: () => void;
   constructor() {}
}
