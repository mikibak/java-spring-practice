import { SkiResort } from "../../skiResort/model/skiResort";

/**
 * Represents single slope in list.
 */
export interface SlopeDetails {

  /**
   * Unique id identifying slope.
   */
  id: string;

  /**
   * Name of the slope.
   */
  name: string;

  /**
   * Slope's background story.
   */
  steepness: number;

  /**
   * Slope's skiResort.
   */
  skiResort: SkiResort;

}
