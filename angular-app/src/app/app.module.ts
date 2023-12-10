import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './component/footer/footer.component';
import { HeaderComponent } from './component/header/header.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";
import { SlopeListComponent } from './slope/view/slope-list/slope-list.component';
import { SlopeService } from './slope/service/slope.service';
import { SlopeViewComponent } from './slope/view/slope-view/slope-view.component';
import { SlopeEditComponent } from './slope/view/slope-edit/slope-edit.component';
import { FormsModule } from "@angular/forms";
import { SkiResortListComponent } from './skiResort/view/ski-resort-list/ski-resort-list.component';
import { SkiResortEditComponent } from './skiResort/view/ski-resort-edit/ski-resort-edit.component';
import { SkiResortViewComponent } from './skiResort/view/ski-resort-view/ski-resort-view.component';
import {SkiResortService} from "./skiResort/service/skiResort.service";

/**
 * Application main module.
 */
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
    NavComponent,
    MainComponent,
    SlopeListComponent,
    SlopeViewComponent,
    SlopeEditComponent,
    SkiResortListComponent,
    SkiResortEditComponent,
    SkiResortViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    SlopeService,
    SkiResortService,
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
