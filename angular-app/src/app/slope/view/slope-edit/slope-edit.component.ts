import { Component, OnInit } from '@angular/core';
import { SlopeService } from '../../service/slope.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SlopeForm } from '../../model/slope-form';
import { SkiResortService } from "../../../skiResort/service/skiResort.service";
import { SkiResorts } from "../../../skiResort/model/skiResorts";

@Component({
  selector: 'app-slope-edit',
  templateUrl: './slope-edit.component.html',
  styleUrls: ['./slope-edit.component.css']
})
export class SlopeEditComponent implements OnInit {

  /**
   * Slope's id.
   */
  uuid: string | undefined;

  /**
   * Single slope.
   */
  slope: SlopeForm | undefined;

  /**
   * Single slope.
   */
  original: SlopeForm | undefined;

  /**
   * Available skiResorts.
   */
  skiResorts: SkiResorts | undefined;

  /**
   * @param slopeService slope service
   * @param skiResortService skiResort service
   * @param route activated route
   * @param router router
   */
  constructor(
    private slopeService: SlopeService,
    private skiResortService: SkiResortService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.skiResortService.getSkiResorts()
        .subscribe(skiResorts => this.skiResorts = skiResorts);

      this.slopeService.getSlope(params['uuid'])
        .subscribe(slope => {
          this.uuid = slope.id;
          this.slope = {
            name: slope.name,
            steepness: slope.steepness,
            skiResort: slope.skiResort.id
          };
          this.original = {...this.slope};
        });
    });
  }

  /**
   * Updates slope.
   */
  onSubmit(): void {
    this.slopeService.putSlope(this.uuid!, this.slope!)
      .subscribe(() => this.router.navigate(['/slopes']));
  }

}
