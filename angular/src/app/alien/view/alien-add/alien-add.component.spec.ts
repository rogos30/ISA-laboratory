import {ComponentFixture, TestBed} from '@angular/core/testing';
import {AlienAddComponent} from './alien-add.component';

describe('AlienAddComponent', ()=> {
  let component: AlienAddComponent;
  let fixture: ComponentFixture<AlienAddComponent>
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AlienAddComponent]
    });
    fixture = TestBed.createComponent(AlienAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
