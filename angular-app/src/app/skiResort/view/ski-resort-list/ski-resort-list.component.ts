import { Component, OnInit } from '@angular/core';
import { SkiResortService } from "../../service/skiResort.service";
import { SkiResorts } from "../../model/skiResorts";
import { SkiResort } from "../../model/skiResort";

@Component({
  selector: 'app-ski-resort-list',
  templateUrl: './ski-resort-list.component.html',
  styleUrls: ['./ski-resort-list.component.css']
})
export class SkiResortListComponent {

  /**
   * @param service slopes service
   */
  constructor(private service: SkiResortService) {
  }

  /**
   * Available slopes.
   */
  skiResorts: SkiResorts | undefined;

  ngOnInit(): void {
    this.service.getSkiResorts().subscribe(skiResorts => this.skiResorts = skiResorts);
  }

  /**
   * Deletes selected slope.
   *
   * @param slope slope to be removed
   */
  onDelete(skiResort: SkiResort): void {
    this.service.deleteSkiResort(skiResort.id).subscribe(() => this.ngOnInit());
  }

}
