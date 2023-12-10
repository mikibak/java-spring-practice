import { Component, OnInit } from '@angular/core';
import { SlopeService } from "../../service/slope.service";
import { Slopes } from "../../model/slopes";
import { Slope } from "../../model/slope";

@Component({
  selector: 'app-slope-list',
  templateUrl: './slope-list.component.html',
  styleUrls: ['./slope-list.component.css']
})
export class SlopeListComponent implements OnInit{

  /**
   * @param service slopes service
   */
  constructor(private service: SlopeService) {
  }

  /**
   * Available slopes.
   */
  slopes: Slopes | undefined;

  ngOnInit(): void {
    this.service.getSlopes().subscribe(slopes => this.slopes = slopes);
  }

  /**
   * Deletes selected slope.
   *
   * @param slope slope to be removed
   */
  onDelete(slope: Slope): void {
    this.service.deleteSlope(slope.id).subscribe(() => this.ngOnInit());
  }

}
