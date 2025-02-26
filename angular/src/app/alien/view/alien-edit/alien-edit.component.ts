import {Component, OnInit} from '@angular/core';
import {AlienService} from '../../service/alien.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Motherships} from '../../../mothership/model/motherships';
import {AlienForm} from '../../model/alien-form';
import {MothershipService} from '../../../mothership/service/mothership.service';

@Component({
  selector: 'app-alien-edit',
  templateUrl: './alien-edit.component.html',
  standalone: false,
  styleUrls: ['./alien-edit.component.css']
})
export class AlienEditComponent implements OnInit {
  uuid: string | undefined;
  alien: AlienForm | undefined;
  original: AlienForm | undefined;
  motherships: Motherships | undefined;

  constructor(
    private alienService: AlienService,
    private mothershipService: MothershipService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.mothershipService.getMotherships()
        .subscribe(motherships => this.motherships = motherships);

      this.alienService.getAlien(params['uuid'])
        .subscribe(alien => {
          this.uuid = alien.id;
          this.alien = {
            name: alien.name,
            power: alien.power,
            mothershipId: alien.mothership.id
          };
          this.original = {...this.alien};
        });
    });
  }

  onSubmit(): void {
    this.alienService.updateAlien(this.uuid!, this.alien!)
      .subscribe(() => this.router.navigate(['/aliens']));

  }
}
