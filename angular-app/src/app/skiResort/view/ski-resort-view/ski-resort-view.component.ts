import { Component, OnInit } from '@angular/core';
import { SkiResortService } from "../../service/skiResort.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SkiResortDetails } from "../../model/ski-resort-details";

/**
 * Preview of single slope.
 */
@Component({
  selector: 'app-ski-resort-view',
  templateUrl: './ski-resort-view.component.html',
  styleUrls: ['./ski-resort-view.component.css']
})
export class SkiResortViewComponent implements OnInit {

  /**
   * Single slope.
   */
  skiResort: SkiResortDetails | undefined;

  /**
   *
   * @param service slope service
   * @param route activated route
   * @param router router
   */
  constructor(private service: SkiResortService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getSkiResort(params['uuid'])
        .subscribe(skiResort => this.skiResort = skiResort)
    });
  }

}
