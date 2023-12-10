import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SlopeListComponent } from "./slope/view/slope-list/slope-list.component";
import { SlopeViewComponent } from "./slope/view/slope-view/slope-view.component";
import { SlopeEditComponent } from "./slope/view/slope-edit/slope-edit.component";

/**
 * All available routes.
 */
const routes: Routes = [
  {
    component: SlopeListComponent,
    path: "slopes"
  },
  {
    component: SlopeViewComponent,
    path: "slopes/:uuid"
  }
  ,
  {
    component: SlopeEditComponent,
    path: "slopes/:uuid/edit"
  }
];

/**
 * Global routing module.
 */
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
