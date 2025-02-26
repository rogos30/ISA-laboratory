import {Mothership} from '../../mothership/model/mothership';

export interface AlienDetails {
  id: string;
  name: string;
  power: number;
  mothership: Mothership;
}
