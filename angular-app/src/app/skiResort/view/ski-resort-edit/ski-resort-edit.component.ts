import { Component, OnInit } from '@angular/core';
import { SkiResortService } from '../../service/skiResort.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SkiResortForm } from '../../model/ski-resort-form';
import {Slopes} from "../../../slope/model/slopes";
import {SlopeService} from "../../../slope/service/slope.service";

@Component({
  selector: 'app-ski-resort-edit',
  templateUrl: './ski-resort-edit.component.html',
  styleUrls: ['./ski-resort-edit.component.css']
})
export class SkiResortEditComponent implements OnInit {

  /**
   * Slope's id.
   */
  uuid: string | undefined;

  /**
   * Single skiResort.
   */
  skiResort: SkiResortForm | undefined;

  /**
   * Single skiResort.
   */
  original: SkiResortForm | undefined;

  /**
   * Available slopes.
   */
  slopes: Slopes | undefined;

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
      this.slopeService.getSlopes()
        .subscribe(slopes => this.slopes = slopes);

      this.skiResortService.getSkiResort(params['uuid'])
        .subscribe(skiResort => {
          this.uuid = skiResort.id;
          this.skiResort = {
            name: skiResort.name,
            visitors: skiResort.visitors,
          };
          this.original = {...this.skiResort};
        });
    });
  }

  /**
   * Updates slope.
   */
  onSubmit(): void {
    this.skiResortService.putSkiResort(this.uuid!, this.skiResort!)
      .subscribe(() => this.router.navigate(['/skiResorts']));
  }

}
