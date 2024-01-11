import { Slope } from "./slope";

/**
 * GET slopes response. Contains list of available slopes. Can be used to list particular user's slopes as
 * well as all slopes in the game.
 */
export interface Slopes {

  /**
   * Name of the selected slopes.
   */
  slopes:Slope[];

}
