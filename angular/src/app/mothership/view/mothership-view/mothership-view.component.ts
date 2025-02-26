import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MothershipDetails} from '../../model/mothership-details';
import {MothershipService} from '../../service/mothership.service';
import {AlienDetails} from '../../../alien/model/alien-details';
import {AlienService} from '../../../alien/service/alien.service';
import {Aliens} from '../../../alien/model/aliens';

@Component({
  selector: 'app-mothership-view',
  templateUrl: './mothership-view.component.html',
  standalone: false,
  styleUrls: ['./mothership-view.component.css']
})
export class MothershipViewComponent implements OnInit {
  constructor(private mothershipService: MothershipService, private alienService: AlienService, private route: ActivatedRoute, private router: Router) {
  }

  mothership: MothershipDetails | undefined;
  aliens: Aliens | undefined;

  ngOnInit() {
    this.route.params.subscribe(params => {
      const mothershipId = params['uuid'];
      this.mothershipService.getMothership(mothershipId)
        .subscribe(mothership => this.mothership = mothership);

      this.alienService.getAliensFromMothership(mothershipId)
        .subscribe(aliens => this.aliens = aliens);
    });

  }
}
