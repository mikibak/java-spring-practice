import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { SkiResorts } from "../model/skiResorts";

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

}
