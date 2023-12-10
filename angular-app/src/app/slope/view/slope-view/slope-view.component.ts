import { Component, OnInit } from '@angular/core';
import { SlopeService } from "../../service/slope.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SlopeDetails } from "../../model/slope-details";

/**
 * Preview of single slope.
 */
@Component({
  selector: 'app-slope-view',
  templateUrl: './slope-view.component.html',
  styleUrls: ['./slope-view.component.css']
})
export class SlopeViewComponent implements OnInit {

  /**
   * Single slope.
   */
  slope: SlopeDetails | undefined;

  /**
   *
   * @param service slope service
   * @param route activated route
   * @param router router
   */
  constructor(private service: SlopeService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSlope(params['uuid'])
        .subscribe(slope => this.slope = slope)
    });
  }

}
