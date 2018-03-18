import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlashcardSetEditComponent } from './flashcard-set-edit.component';

describe('FlashcardSetEditComponent', () => {
  let component: FlashcardSetEditComponent;
  let fixture: ComponentFixture<FlashcardSetEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlashcardSetEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlashcardSetEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
