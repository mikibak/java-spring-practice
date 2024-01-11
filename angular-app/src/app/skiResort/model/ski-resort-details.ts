import { Slopes } from "../../slope/model/slopes";

/**
 * Represents single SkiResort in list.
 */
export interface SkiResortDetails {

  /**
   * Unique id identifying slope.
   */
  id: string;

  /**
   * Name of the slope.
   */
  name: string;

  /**
   * Slope's visitors.
   */
  visitors: number;

}
