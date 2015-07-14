package com.vainolo.opm.editor.navigator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.ITextContentDescriber;


public class OPDescriber implements ITextContentDescriber {

	@Override
	public int describe(InputStream contents, IContentDescription description) throws IOException {
		return 0;
	}

	@Override
	public QualifiedName[] getSupportedOptions() {
		return null;
	}

	@Override
	public int describe(Reader contents, IContentDescription description) throws IOException {
		return 0;
	}
}
