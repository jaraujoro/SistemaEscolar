import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { register as registerSwiperElements } from 'swiper/element/bundle';
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

registerSwiperElements();
bootstrapApplication(AppComponent, {
  ...appConfig,
  providers: [...appConfig.providers, importProvidersFrom(HttpClientModule)],
}).catch((err) => console.error(err));
