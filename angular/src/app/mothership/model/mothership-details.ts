import {Alien} from '../../alien/model/alien';

export interface MothershipDetails {
  id: string;
  name: string;
  power: number;
  mothership: Alien;
}
