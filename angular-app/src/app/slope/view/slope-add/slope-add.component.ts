import { Component, OnInit } from '@angular/core';
import { SlopeService } from '../../service/slope.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SlopeForm } from '../../model/slope-form';
import { SkiResortService } from "../../../skiResort/service/skiResort.service";
import { SkiResorts } from "../../../skiResort/model/skiResorts";
import {SkiResort} from "../../../skiResort/model/skiResort";

@Component({
  selector: 'app-slope-add',
  templateUrl: './slope-add.component.html',
  styleUrls: ['./slope-add.component.css']
})
export class SlopeAddComponent implements OnInit {

  /**
   * Slope's id.
   */
  uuid: string | undefined;

  /**
   * Single slope.
   */
  slope: SlopeForm;

  /**
   * Single slope.
   */
  skiResort: SkiResort | undefined;

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
    this.slope = {
      name:'',
      steepness: 0,
      skiResort: '',
    }
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.skiResortService.getSkiResorts()
        .subscribe(skiResorts => this.skiResorts = skiResorts);
    });

    this.route.params.subscribe(params => {
      this.skiResortService.getSkiResort(params['uuid'])
        .subscribe(skiResort => {
          this.uuid = skiResort.id;
          this.skiResort = {
            id: skiResort.id,
            name: skiResort.name,
            visitors: skiResort.visitors,
          };
          this.slope.skiResort = this.skiResort.id;
        });
    });


    this.uuid = 'f5875513-bf7b-4ae1-b8a5-5b70a1b90333';
  }

  /**
   * Updates slope.
   */
  onSubmit(): void {
    this.slopeService.putSlope(this.uuid!, this.slope!)
      .subscribe(() => this.router.navigate(['/slopes']));
  }

}
