import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Motherships} from '../../model/motherships';
import {MothershipService} from '../../service/mothership.service';
import {MothershipForm} from '../../model/mothership-form';

@Component({
  selector: 'app-mothership-edit',
  templateUrl: './mothership-edit.component.html',
  standalone: false,
  styleUrls: ['./mothership-edit.component.css']
})
export class MothershipEditComponent implements OnInit {
  uuid: string | undefined;
  mothership: MothershipForm | undefined;
  original: MothershipForm | undefined;
  motherships: Motherships | undefined;

  constructor(
    private mothershipService: MothershipService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.mothershipService.getMothership(params['uuid'])
        .subscribe(mothership => {
          this.uuid = mothership.id;
          this.mothership = {
            name: mothership.name,
            power: mothership.power
          };
          this.original = {...this.mothership};
        });
    });
  }

  onSubmit(): void {
    this.mothershipService.updateMothership(this.uuid!, this.mothership!)
      .subscribe(() => this.router.navigate(['/motherships']));
  }
}
