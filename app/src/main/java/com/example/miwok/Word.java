package com.example.miwok;

    /**
     * {@link Word} represents a vocabulary word that the user wants to learn.
     * It contains a default translation and a Miwok translation for that word.
     */
    public class Word {

        /** Default translation for the word */
        private String mDefaultTranslation;

        /** Miwok translation for the word */
        private String mMiwokTranslation;


        /**Integer image Resource Id variable*:private integer variable*/
//        private int mImageResourceId;
        private int mImageResourceId = NO_IMAGE_PROVIDED;
        /** Constant value that represents no image was provided for this word */
        private static final int NO_IMAGE_PROVIDED = -1;

        /** Audio resource ID for the word */
        private int mAudioResourceId;

        /**
         * Create a new Word object.
         *
         * @param defaultTranslation is the word in a language that the user is already familiar with
         *                           (such as English)
         * @param miwokTranslation is the word in the Miwok language
         */
        public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mAudioResourceId = audioResourceId;
        }

//        /**
//         *Create a new Word object.
//         *
//         * @param defaultTranslation is the word in a language that the user is already familiar with
//         *          *                           (such as English)
//         * @param miwokTranslation is the word in the Miwok language
//         *
//         * @param imageResourceId is the drawable resource ID for the image asset
//         */
//        public Word(String defaultTranslation, String miwokTranslation,int imageResourceId) {
//            mDefaultTranslation = defaultTranslation;
//            mMiwokTranslation = miwokTranslation;
//            mImageResourceId = imageResourceId;
//        }

        /**
         *Create a new Word object.
         *
         * @param defaultTranslation is the word in a language that the user is already familiar with
         *          *                           (such as English)
         * @param miwokTranslation is the word in the Miwok language
         *
         * @param imageResourceId is the drawable resource ID for the image asset
         *
         * @param audioResourceId is the raw resource ID for the audio asset
         */
        public Word(String defaultTranslation, String miwokTranslation,int imageResourceId, int audioResourceId) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mImageResourceId = imageResourceId;
            mAudioResourceId = audioResourceId;
        }

        /**
         * Get the default translation of the word.
         */
        public String getDefaultTranslation() {
            return mDefaultTranslation;
        }

        /**
         * Get the Miwok translation of the word.
         */
        public String getMiwokTranslation() {
            return mMiwokTranslation;
        }

        /**
         * Return the image resource ID of the word.
         */
        public int getImageResourceId (){ return mImageResourceId;}

        /**
         * Return the audio resource ID of the word.
         */
        public int getAudioResourceId (){ return mAudioResourceId;}

        /**
         * Returns whether or not there is an image for this word.
         */
        public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }


        /**
         * Returns the string representation of the {@link Word} object.
         */
        @Override
        public String toString() {
            return "Word{" +
                    "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                    ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                    ", mImageResourceId=" + mImageResourceId +
                    ", mAudioResourceId=" + mAudioResourceId +
                    '}';
        }
    }

