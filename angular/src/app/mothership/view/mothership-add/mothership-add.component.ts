import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {MothershipService} from '../../service/mothership.service';
import {MothershipForm} from '../../model/mothership-form';

@Component({
  selector: 'app-alien-add',
  templateUrl: './mothership-add.component.html',
  standalone: false,
  styleUrls: ['./mothership-add.component.css']
})
export class MothershipAddComponent implements OnInit {
  mothership: MothershipForm = {
    name: '',
    power: 0
  };

  constructor(
    private mothershipService: MothershipService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit() {
  }

  onSubmit(): void {
    this.mothershipService.createMothership(this.mothership!)
      .subscribe(() => this.router.navigate(['/motherships']));
  }
}
