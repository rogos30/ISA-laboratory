import {Component, OnInit} from '@angular/core';
import {AlienService} from '../../service/alien.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Motherships} from '../../../mothership/model/motherships';
import {AlienForm} from '../../model/alien-form';
import {MothershipService} from '../../../mothership/service/mothership.service';

@Component({
  selector: 'app-alien-add',
  templateUrl: './alien-add.component.html',
  standalone: false,
  styleUrls: ['./alien-add.component.css']
})
export class AlienAddComponent implements OnInit {
  alien: AlienForm = {
    name: '',
    power: 0,
    mothershipId: ''
  };
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
    });
  }

  onSubmit(): void {
    this.alienService.createAlien(this.alien!)
      .subscribe(() => this.router.navigate(['/aliens']));
  }
}
