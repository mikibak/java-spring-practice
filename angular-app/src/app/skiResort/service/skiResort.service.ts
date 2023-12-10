import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { SkiResorts } from "../model/skiResorts";
import {SkiResort} from "../model/skiResort";
import {SkiResortForm} from "../model/ski-resort-form";
import {SkiResortDetails} from "../model/ski-resort-details";

/**
 * SkiResort management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class SkiResortService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all skiResorts.
   *
   * @return list of skiResorts
   */
  getSkiResorts(): Observable<SkiResorts> {
    return this.http.get<SkiResorts>('/api/skiResorts');
  }

  deleteSkiResort(uuid: string) {
    return this.http.delete('/api/skiResorts/' + uuid);
  }

  getSkiResort(uuid: string) {
    return this.http.get<SkiResortDetails>('/api/skiResorts/' + uuid);
  }

  putSkiResort(uuid: string, skiResortForm: SkiResortForm) {
    return this.http.put('/api/skiResorts/' + uuid, skiResortForm);
  }
}
