clear all;
close all;
clc

%% LAB 2 - Fourier Analysis:

%% Question 1

n = 1:200; %Create 200 samples of a discrete sine wave
f = 5; %with frequency 5Hz (five oscillations / second),
fs = 100; %sampled at 100HZ
x = sin(2*pi*f/fs*n); %Remember that the theoretical expression of a generic discrete sine wave of frequency f, sampled with sampling frequency fs is x[n] = sin(2πf/fs*n).
%-> x is my signal

t = (n-1)/fs; %correseponding time vector

figure('Name','Self-made signal')
plot(t,x) %plot of newly generated sine wave
%-> duration of signal is 2s (200 samples with fs = 100)

%Remember that the Fourier transform consists of complex numbers. Complex number in polar
%coordinates have two components, a modulus and an argument. It is convenient to look at these
%two components separately when analyzing the frequency content of a signal. You can plot these
%two components by means of the functions abs and angle, respectively. The plot of the *modulus* of
%the Fourier transform of a signal is called the *amplitude spectrum*,
%while the plot of the *argument*
%is called the *phase spectrum* of the signal. 

%Amplitude and phase specturm can be obtained by doing:
figure('Name','Amplitude and Phase Spectra of self-made signal')
%Build frequency vector : f = ((0:n-1)*fs)/n ------  f = (0:length(DFT)-1)*Fs/length(DFT)
f = (0:length(n)-1)*fs/length(n);
% --> NECESSARY TO PLOT SIGNAL VERSUS FREQUENCIES!
Sx = fft(x);
subplot(2,1,1)
plot(f,abs(Sx)) %-> Abs to find modulus so amplitude
title('amplitude spectrum')
subplot(2,1,2)
plot(f,angle(Sx)) %-> angle to find argument so sphase
title('phase spectrum')
xlabel('frequency (Hz)')


% %try again with f=100*t to see if similar:
% f=100*t; %%works better like this
% figure ()
% Sx = fft(x);
% subplot(2,1,1)
% plot(f,abs(Sx)) %-> Abs to find modulus so amplitude
% title('amplitude spectrum')
% subplot(2,1,2)
% plot(f,angle(Sx)) %-> angle to find argument so sphase
% title('phase spectrum')
% xlabel('frequency (Hz)')
% %--> Does not work! axes are then wrong even though we hvae the same
% %looking graph.

%-->
% *Amplitude Spectrum*:
% The amplitude spectrum of a signal shows the amplitudes (strengths) of the different frequency components that make up the signal. It provides information about how much of each frequency is present in the signal.
% Key Information:
% Dominant frequencies: Peaks in the amplitude spectrum indicate the dominant frequencies in the signal.
% Frequency distribution: It shows the distribution of energy across different frequencies, helping to identify prominent frequency components.
% Relative strengths: The amplitude values at each frequency indicate how strong or weak each frequency component is in the signal.
% Applications: 
% Audio analysis: Identifying individual notes in music, distinguishing different instruments based on their frequency content.
% Image processing: Detecting patterns or textures based on their spatial frequency components.
% 
% *Phase Spectrum*:
% The phase spectrum of a signal shows the phase shifts associated with each frequency component. Phase represents the relative timing or alignment of the sinusoidal components at different frequencies.
% Key Information:
% Phase relationships: It reveals how the different frequencies making up the signal are synchronized or out of sync with each other.
% Phase shifts: Identifies the amount of delay or advancement of each frequency component with respect to a reference point.
% Applications: 
% Signal processing: Phase information is crucial for tasks like filtering, modulation, and time-alignment of signals.
% Communication systems: Phase is vital in modulating signals for efficient transmission and demodulating received signals.
% By analyzing the amplitude and phase spectra of a signal, engineers and researchers can gain insights into its frequency composition, timing relationships, and behavior. This information is critical for various applications, including audio and image processing, communication systems, control systems, and more.
% 


%% Question 2

clear all; close all; clc

 t=-10:0.1:10; %Create a discrete time sequence t sampled at 10 Hz in [−10, 10] 
 fs = 10;
 cx = cos(2*pi*t);
 sx = sin(2*pi*t);

figure('Name','Sine and Cosine Plots')
subplot(211)
plot(t,cx);
title cosine
subplot(212)
plot(t,sx);
title sine
%WHAT ARE THEIR FUNDAMENTAL FREQUENCIES? --> Do as in Q1: find amplitude

figure('Name','Sine and Cosine Amplitude and Phase Spectra')

Cx = fft(cx);
f = (0:length(Cx)-1)*fs/length(Cx);
% --> NECESSARY TO PLOT SIGNAL VERSUS FREQUENCIES!
subplot(2,2,1)
plot(f,abs(Cx)) %-> Abs to find modulus so amplitude
title('amplitude spectrum COS')
subplot(2,2,2)
plot(f,angle(Cx)) %-> angle to find argument so sphase
title('phase spectrum COS')
xlabel('frequency (Hz)')


Sx = fft(sx);
f = (0:length(Sx)-1)*fs/length(Sx);
subplot(2,2,3)
plot(f,abs(Sx)) %-> Abs to find modulus so amplitude
title('amplitude spectrum SIN')
subplot(2,2,4)
plot(f,angle(Sx)) %-> angle to find argument so sphase
title('phase spectrum SIN')
xlabel('frequency (Hz)')


%Find exact fundamental frequencies: 
maxValueCos = max(Cx);
maxValueSin = max(Sx);


%%%????????????


%% Question 3
% Create a function plotfft that displays the amplitude and phase spectrum of a given signal, provided as input to the function.

%TEST FUNCTION
plotfft(cx,10)

%WORKS WELL!

%% Question 4
%Repeat 2, but then with a sampling period of 1.1 (instead of 0.1)


close all
clc
ts = 1.1;
fs = 1/ts;

plotfft(cx, fs)
plotfft(sx, fs)
%%????
% DOES NOT WORK THAT WAY

%% 4 AGAIN

clear all; close all; clc

 t=-10:1.1:10; %Create a discrete time sequence t sampled at 10 Hz in [−10, 10] 
 fs = 10;
 cx = cos(2*pi*t);
 sx = sin(2*pi*t);

figure('Name','Sine and Cosine Plots')
subplot(211)
plot(t,cx);
title cosine
subplot(212)
plot(t,sx);
title sine
%WHAT ARE THEIR FUNDAMENTAL FREQUENCIES? --> Do as in Q1: find amplitude

figure('Name','Sine and Cosine Amplitude and Phase Spectra')

Cx = fft(cx);
f = (0:length(Cx)-1)*fs/length(Cx);
% --> NECESSARY TO PLOT SIGNAL VERSUS FREQUENCIES!
subplot(2,2,1)
plot(f,abs(Cx)) %-> Abs to find modulus so amplitude
title('amplitude spectrum COS')
subplot(2,2,2)
plot(f,angle(Cx)) %-> angle to find argument so sphase
title('phase spectrum COS')
xlabel('frequency (Hz)')


Sx = fft(sx);
f = (0:length(Sx)-1)*fs/length(Sx);
subplot(2,2,3)
plot(f,abs(Sx)) %-> Abs to find modulus so amplitude
title('amplitude spectrum SIN')
subplot(2,2,4)
plot(f,angle(Sx)) %-> angle to find argument so sphase
title('phase spectrum SIN')
xlabel('frequency (Hz)')


%Find exact fundamental frequencies: 
maxValueCos = max(Cx);
maxValueSin = max(Sx);

%Why Does this Happen?
% The Nyquist-Shannon sampling theorem states that to accurately represent a signal, the sampling rate must be at least twice the highest frequency present in the signal.
% With the larger sampling period of 1.1, the sampling rate decreases, and the Nyquist frequency (half of the sampling rate) becomes lower.
% Consequently, the frequency resolution decreases, and the ability to accurately represent higher frequencies is compromised.
% In summary, increasing the sampling period reduces the effective sampling rate, leading to a lower Nyquist frequency and affecting the representation of higher frequencies in the signal. This can result in changes in the amplitude and phase spectra, impacting the accuracy of the frequency analysis.

%% Question 5
clear all; close all; clc

load dataset1.mat

fs = samplesPerSecond;
fft_result = fft(y); %--> use y not x!!! (e.g., y=cosx)
f_vec = (0:length(fft_result)-1)*fs/length(fft_result);
amplitude = abs(fft_result);
phase = unwrap(angle(fft_result)); %unwraps the radian phase angles in a vector P. Whenever the jump between consecutive angles is greater than or equal to π radians, unwrap shifts the angles by adding multiples of ±2π until the jump is less than π.

figure('Name', 'Dataset1 exercices')
subplot(311)
plot(x,y)
title ORIGINAL SIGNAL
xlabel('time (s)')


subplot(312)
plot(f_vec, amplitude)
title Amplitude
axis auto

subplot(313)
plot(f_vec, phase)
title Phase
axis auto


%%% WHY DONT I GET THE RIGHT THING?? PHASE SPECTRUM IS WRONG WTF???

% %
% The signal consists of two harmonics; one frequency
% of interest and one power line interference. Estimate the frequencies of these harmonics from the
% amplitude spectrum. Determine a suitable interval that removes the power line interference. Next,
% apply this filter to the Fourier domain data. Plot the amplitude spectra of the original and filtered
% Fourier-domain data overlapped in the same plot.
% %



%find the different peaks
[pks,locs] = findpeaks(amplitude,f_vec,'MinPeakHeight', 0.1,'MinPeakDistance', 10);

%from previously plotted grqph, find the frequencies we should keep and
%those we should remove
wantedFrequency1 = locs(2);
wantedFrequency2 = locs(3);

unwantedFreq1 = locs(1);
unwantedFreq2 = locs(4);

%Determine intervals to remove what we dont want
interval1 = [unwantedFreq1-10, unwantedFreq1+10 ];
interval2 = [unwantedFreq2-10, unwantedFreq2+10 ];

%make filter and apply to the Fourier domain data
filter = ones(size(f_vec));
filter(f_vec >= interval1(1) & f_vec <= interval1(2)) = 0;
filter(f_vec >= interval2(1) & f_vec <= interval2(2)) = 0;

filtered_fft_result = filter .* fft_result; %--> NEED TO BE THE SAME SIZE ?????????????????????????????? now ok!!! f_vec not amplitude (take x not y axis)


% Create a new plot and plot the amplitude spectra of the original and filtered Fourier-domain data on the same plot
figure('Name', 'Ampl and Phase of original and filtered')
plot(amplitude, 'linewidth', 1.5);
hold on;
filtered_amplitude = abs(filtered_fft_result);
plot(filtered_amplitude, 'linewidth', 2);
xlabel('Frequency (Hz)');
ylabel('Amplitude');
legend('Original signal', 'Filtered signal');
title('Amplitude spectra of the original and filtered Fourier-domain data');

%% Question 6

%Calculate the inverse Fourier transform of the filtered Fourier-domain data with the function
%ifft, and then apply the function real to the result. Plot the original signal, the filtered signal and
%the difference between the two and check that you have successfully separated the two harmonics.

%ORIGINAL 
%from q5

%FILTERED
%from q5
filtered_signal = ifft(filtered_fft_result);
real_filtered_signal = real(filtered_signal);


%DIFFERENCE
difference = y-real_filtered_signal;

figure('Name', 'Original, filtered and Difference Plots of Signal')
plot(x,y, 'linewidth', 1.3) %-> original
hold on 
plot(x, real_filtered_signal, 'linewidth', 1.3) %-> Filtered 
hold on 
plot(x, difference, 'linewidth', 1.5) %-> Difference 
title ORIGINAL SIGNAL
xlabel('time (s)')
legend('Original signal', 'Filtered signal', 'Difference original-filtered');


%% Question 7
% clear all; close all; clc

[sg1_gray, map_gray] = imread('sg1_gray.tif');

im1 = double(sg1_gray);

figure('Name', 'sg1_gray')
imagesc(im1)
colormap(gray) %WHY LIKE THIS NOW??

figure('Name', 'sg1_gray FFT')
im_fft = fft2(im1);
spectrum = fftshift(abs(im_fft));
imagesc(spectrum)
colormap gray

%dark image might be due to the magnitude values being very low.

%let's try to visualize the amplitude spectrum?

%% Question 8

figure('Name','Power Spectrum in Frequency Domain')
imagesc(fftshift(log(abs(im_fft)+1)))

colormap(gray)

%% Question 9
% clc
% 
%Load the two images, sg1_gray.tif, and peppers_gray.tif using imagesc
sg1_gray = imread('sg1_gray.tif');
peppers = imread('peppers_gray.tif');
im1 = double(sg1_gray);
im2 = double(peppers);

%Perform the Fourier Transform on both images
im1_fft = fft2(im1);
im2_fft = fft2(im2);


%Split the information into their amplitude and phase components:
im1M = abs(im1_fft);
im1P = angle(im1_fft);
im2M = abs(im2_fft);
im2P = angle(im2_fft);


%Combine the two images so that the amplitude of im1 is combined with the phase of im2 and vice
%versa. This can be done by
% im12_ftt = im1M.*(cos(im2P)+1i*sin(im2P));
% im21_fft = im2M.*(cos(im1P)+1i*sin(im1P));
% ----> DOES NOT WORK SO USE EULER'S VERSION

%NOTCH FIILTER?? nope?
im12_fft = im1M .* exp(1i * im2P);
im21_fft = im2M .* exp(1i * im1P);

%Now perform the Inverse Fourier Transform and look at the resulting images
inverse_im12 = ifft2(im12_fft);
inverse_im21 = ifft2(im21_fft); % ATTENTION USE HERE IFFT2! not ifft

figure('Name', 'Q9 - Inverse Fourier of Results')

subplot 221
imagesc(sg1_gray)
title('Original SG1 Image')
colormap gray

subplot 222
imagesc(peppers)
title('Original Peppers Image')
colormap gray


subplot 223
imagesc(abs(inverse_im21))
title ('Magnitude of inverse 21')
colormap gray

subplot 224
imagesc(abs(inverse_im12))
title('Magnitude of inverse 12')
colormap gray

























