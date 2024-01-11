import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Slopes } from "../model/slopes";
import { SlopeDetails } from "../model/slope-details";
import { SlopeForm } from "../model/slope-form";

/**
 * Slope management service. Calls REST endpoints.
 */
@Injectable()
export class SlopeService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all slopes.
   *
   * @return list of slopes
   */
  getSlopes(): Observable<Slopes> {
    return this.http.get<Slopes>('/api/slopes');
  }

  /**
   * Fetches single slopes.
   *
   * @param uuid slope's id
   * @return single slopes
   */
  getSlope(uuid: string): Observable<SlopeDetails> {
    return this.http.get<SlopeDetails>('/api/slopes/' + uuid);
  }

  /**
   * Removes single slope.
   *
   * @param uuid slope's id
   */
  deleteSlope(uuid: string): Observable<any> {
    return this.http.delete('/api/slopes/' + uuid);
  }

  /**
   * Updates single slope.
   *
   * @param uuid slope's id
   * @param request request body
   */
  putSlope(uuid: string, request: SlopeForm): Observable<any> {
    return this.http.put('/api/slopes/' + uuid, request);
  }

}
