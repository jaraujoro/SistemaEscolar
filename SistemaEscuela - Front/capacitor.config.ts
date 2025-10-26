import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.educenter.app',
  appName: 'EduCenter',
  webDir: 'dist/dashboard-app/browser/browser',
  server: {
    androidScheme: 'http',
    cleartext: true, // permite HTTP
    hostname: '192.168.18.195' // opcional, para desarrollo local
  }
};

export default config;
