import { Component, OnInit } from '@angular/core';
import { SkiResortService } from '../../service/skiResort.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SkiResortForm } from '../../model/ski-resort-form';
import {Slopes} from "../../../slope/model/slopes";
import {SlopeService} from "../../../slope/service/slope.service";

@Component({
  selector: 'app-ski-resort-add',
  templateUrl: './ski-resort-add.component.html',
  styleUrls: ['./ski-resort-add.component.css']
})
export class SkiResortAddComponent implements OnInit {

  /**
   * Slope's id.
   */
  uuid: string | undefined;

  /**
   * Single skiResort.
   */
  skiResort: SkiResortForm | undefined;

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
    this.skiResort = {
      name: '',
      visitors: 0
    }
  }

  /**
   * Updates slope.
   */
  onSubmit(): void {
    this.skiResortService.putSkiResort(this.uuid!, this.skiResort!)
      .subscribe(() => this.router.navigate(['/skiResorts']));
  }

}
