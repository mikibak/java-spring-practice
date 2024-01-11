import { Component, OnInit } from '@angular/core';
import { SkiResortService } from "../../service/skiResort.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SkiResortDetails } from "../../model/ski-resort-details";
import {Slope} from "../../../slope/model/slope";

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
  slopes: any;

  /**
   *
   * @param service slope service
   * @param route activated route
   * @param router router
   */
  constructor(private skiResortService: SkiResortService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.skiResortService.getSkiResort(params['uuid'])
        .subscribe(skiResort => this.skiResort = skiResort);
      this.skiResortService.getSkiResortSlopes(params['uuid']).subscribe(slopes => this.slopes = slopes);
    });
  }

  onDelete(slope: Slope): void {
    this.skiResortService.deleteSlope(slope.id).subscribe(() => this.ngOnInit());
  }

}
